#!/usr/bin/env bash
##############################################################################
# Function：机器间免密打通
# Parameters：无
# Date：2022-10-09
##############################################################################

###需要修改配置 start###########################################
# 需要打通ssh的用户名
USER=tongdun
# 需要打通ssh的host name
HOSTS=mingmo-1,mingmo-2,mingmo-3
###需要修改配置 end############################################


###以下脚本内容, 无需修改配置####################################
SCRIPT_NAME=passwordless.sh

hosts=($(echo $HOSTS | tr "," "\n"))

prompt(){
	echo
	echo "SSH免密登录用户: $USER"
	echo "SSH免密登录机器: $HOSTS"
	echo

	while true; do
	    read -p "检查配置是否正确，是否继续进行ssh免密打通? [y/n]" yn
	    case $yn in
	        [Yy]* ) break;;
	        [Nn]* ) exit;;
	        * ) echo "请输入Y/N.";;
	    esac
	done
}

install(){
	prompt
	pub_keys=''
	# 生成sshkey并记录每台机器的sshkey
	for (( i = 1; i <= ${#hosts[*]}; i++ )); do
		host=${hosts[$(($i-1))]}
		pub_key=`ssh $USER@$host "if [[ ! -f ~/.ssh/id_rsa.pub ]]; then ssh-keygen -t rsa -q -f ~/.ssh/id_rsa -N ''; fi; cat ~/.ssh/id_rsa.pub;"`
		pub_keys=$pub_keys'\\n'$pub_key;
		ssh $USER@$host "chmod 700 ~/.ssh; touch ~/.ssh/authorized_keys; chmod 600 ~/.ssh/authorized_keys; touch ~/.ssh/config; chmod 600 ~/.ssh/config"
		ssh $USER@$host "if ! grep -q StrictHostKeyChecking ~/.ssh/config; then echo 'StrictHostKeyChecking no' >> ~/.ssh/config; fi"
	done

	for host in "${hosts[@]}"; do
		ssh $USER@$host "echo -e $pub_keys >> ~/.ssh/authorized_keys"
	done

	check
}

check(){
	# 检查机器间是否打通ssh免密登录
	echo
	echo "检查机器间是否打通ssh免密登录，如果检查过程中还要输入密码，ssh免密登录可能还有问题。"
	read -p "按任意键继续" _
	echo
	for host1 in "${hosts[@]}"; do
		for host2 in "${hosts[@]}"; do
			ssh $USER@$host1 "echo checking $host1 to $host2...; ssh $USER@$host2 echo OK;exit;"
			echo
		done
	done
}


case "$1" in
    install)
        install
    ;;
    check)
        check
    ;;
    *)
    	echo "sh $SCRIPT_NAME [install|check]"
    ;;
esac

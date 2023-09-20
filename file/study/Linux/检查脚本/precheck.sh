#!/usr/bin/env bash
##############################################################################
# Function：软件安装前检查
# Parameters：无
# Date：2022-10-09
##############################################################################
# CUR_PATH：当前执行命令所在路径，BIN_DIR：被执行脚本所在路径
exe_cmd=$0
CUR_PATH=`pwd`
relative_dir=`dirname ${exe_cmd}`
cd $relative_dir
BIN_DIR=`pwd`
cd $CUR_PATH
###需要修改配置 start###########################################################
# 执行前请修改
# 预检查机器列表
precheck_hosts=10.58.11.10,10.58.11.11,10.58.11.12
# 检查用户
precheck_user=tdops

# 可选值（以,分隔）：
#  linux_version
#  java_version
#  python_version
#  charset
#  cpu
#  mem
#  disk
#  date
#  all
# 单次可检测多个选项
#check_type=linux_version,java_version
check_type=all

###需要修改配置 end  ###########################################################
# 以下内容禁止修改
. $BIN_DIR/config.ini
. $BIN_DIR/common_function.sh

servers=($(echo $precheck_hosts | tr "," "\n"))

DATE_YMD=`date +%Y%m%d%H%M`
check_result="check_result_$DATE_YMD.log"
log_info "check starting " $check_result

# 检查操作系统版本号
check_linux_version()
{
  echo
  log_info "check linux version info：" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
		echo "$server linux version: " | tee -a $check_result
		# 执行安装
		ssh $precheck_user@$server " cat /proc/version " | tee -a $check_result
	done
  log_info ">>> linux version check finished."
}

# 检查 java 版本号
check_java_version()
{
  echo
  log_info "check java version info：" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
		echo "$server java version: "
	  ssh $precheck_user@$server '. /etc/profile; . ~/.bashrc; java -version' | tee -a $check_result
	done
  log_info ">>> java version check finished. " $check_result
}

# 检查 python 版本号
check_python_version()
{
  echo
  log_info "check python version info：" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
		echo "$server python version: "
		ssh $precheck_user@$server ". /etc/profile; . ~/.bashrc; python -V " | tee -a $check_result
	done
  log_info ">>> python version check finished." $check_result
}

# 检查环境编码
check_charset()
{
  echo
  log_info "check system charset info：" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
		log_info "$server charset: " $check_result
		# 执行安装
		ssh $precheck_user@$server " locale | grep LANG " | tee -a $check_result

	done
  log_info ">>> Check system charset finished." $check_result
  return 0
}

check_cpu()
{
  echo
  log_info "check cpu info" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
		# 执行安装
		log_info "$server cpu info : " $check_result
		ssh $precheck_user@$server "cat /proc/cpuinfo | grep name  | uniq; echo 'cpu core num:'; cat /proc/cpuinfo | grep 'physical id' | wc -l;" | tee -a $check_result
	done
  log_info " Check cpu info finished." $check_result
  return 0
}

check_mem()
{
  echo
  log_info "check mem info" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
    log_info "$server memory info: " $check_result
    ssh $precheck_user@$server "free -h" | tee -a $check_result
	done
  log_info " Check mem info finished." $check_result
  return 0
}

check_disk()
{
  echo
  log_info "check disk info" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
    log_info "$server disk info: " $check_result
    ssh $precheck_user@$server "df -h" | tee -a $check_result
	done
  log_info ">>> Check disk info finished." $check_result
  return 0
}

# 校验时钟
check_date()
{
  echo
  log_info "check date info" $check_result
  local i=1
  for (( i = 1; i <= ${#servers[*]}; i++ )); do
		server=${servers[$(($i-1))]}
    log_info "$server date info: " $check_result
    ssh $precheck_user@$server " date -d today +'%Y-%m-%d %H:%M:%S'" | tee -a $check_result
	done
  log_info ">>> Check date info finished." $check_result
  return 0
}


main()
{
  log_info "Execute check task $check_type starting." $check_result
  if [ "${check_type}x" != "x" ]; then
    check_list=($(echo $check_type | tr "," "\n"))
    for (( param_i = 1; param_i <= ${#check_list[*]}; param_i++ )); do
        check=${check_list[$(($param_i-1))]}
        case "$check" in
          linux_version)
            echo "check_linux_version"
            check_linux_version
          ;;
          java_version)
            echo "check_java_version"
            check_java_version
          ;;
          python_version)
            check_python_versio
          ;;
          charset)
            check_charset
          ;;
          cpu)
            check_cpu
          ;;
          mem)
            check_mem
          ;;
          disk)
            check_disk
          ;;
          date)
            check_date
          ;;
          all)
            check_linux_version
            check_java_version
            check_python_version
            check_charset
            check_cpu
            check_mem
            check_disk
            check_date
          ;;
          *)
            echo "Not support operate type."
          ;;
        esac
    done
  fi


  log_info "Check finished." $check_result
}

##############################################################################
# shellcheck disable=SC2068
main $@
cd $CUR_PATH
##############################################################################
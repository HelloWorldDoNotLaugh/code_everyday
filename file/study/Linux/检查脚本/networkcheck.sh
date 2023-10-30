#!/bin/bash

# SSH 用户名
ssh_user="tongdun"

# 主机列表
hosts=("mm1" "mm2" "mm3")

# 存储SSH连接和ping结果的数组
ssh_results=()
ping_results=()

# 输出失败的SSH连接结果和ping结果
failed_ssh_results=()
failed_ping_results=()

for host in "${hosts[@]}"
do
    echo "Connecting to $host via SSH..."

    # 尝试 SSH 连接
    ssh -q -o BatchMode=yes -o ConnectTimeout=5 "$ssh_user@$host" exit

    if [ $? -eq 0 ]; then
        ssh_results+=("ssh $host: Success")
    else
        failed_ssh_results+=("ssh $host: Failure")
    fi

    echo "-------------------"

    for ip in "${hosts[@]}"
    do
        echo "Pinging $ip from $host"

        success=false

        # 尝试执行 ping 命令 10 次
        for ((i=1; i<=10; i++))
        do
            if ping -c 1 "$ip" &>/dev/null; then
                success=true
                break
            fi
        done

        if $success; then
            ping_results+=("$host -> $ip: Success")
        else
            failed_ping_results+=("$host -> $ip: Failure")
        fi

        echo "-------------------"
    done
done

echo " "

if [ ${#failed_ssh_results[@]} -gt 0 ]; then
    echo "SSH Connection Failure Results:"
    for result in "${failed_ssh_results[@]}"
    do
        echo "$result"
    done
else
    echo "SSH All Success!"
fi

echo " "

if [ ${#failed_ping_results[@]} -gt 0 ]; then
    echo "Ping Failure Results:"
    for result in "${failed_ping_results[@]}"
    do
        echo "$result"
    done
else
    echo "Ping All Success!"
fi

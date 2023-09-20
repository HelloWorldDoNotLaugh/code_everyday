
## todo
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
#!/bin/bash

/etc/rc.d/init.d/hinemos_agent start
status=$?
if [ $status -ne 0 ]; then
  echo "Failed to start hinemos_agent: $status"
  exit $status
fi

/usr/sbin/snmpd -LS0-6d
status=$?
if [ $status -ne 0 ]; then
  echo "Failed to start snmpd: $status"
  exit $status
fi

rm -rf /var/run/rsyslogd.pid
/usr/sbin/rsyslogd -n
status=$?
if [ $status -ne 0 ]; then
  echo "Failed to start rsyslog: $status"
  exit $status
fi

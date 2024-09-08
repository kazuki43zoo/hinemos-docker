FROM oraclelinux:9

ENV HINEMOS_MAJOR 7.1
ENV HINEMOS_MINOR 0
ENV HINEMOS_MANAGER operation-manager
ENV MANAGER_IP_ADDRESS operation-manager

RUN yum -y update \
 && yum -y install java-1.8.0-openjdk hostname openssh-clients net-snmp net-snmp-libs net-snmp-utils libpcap lsof syslog rsyslog vim-common glibc-langpack-ja \
 && yum -y install https://github.com/hinemos/hinemos/releases/download/v${HINEMOS_MAJOR}.${HINEMOS_MINOR}/hinemos-${HINEMOS_MAJOR}-agent-${HINEMOS_MAJOR}.${HINEMOS_MINOR}-1.el.noarch.rpm \
 && yum clean all \
 && rm -rf /var/cache/yum

ENV LANG="ja_JP.UTF-8" \
    LANGUAGE="ja_JP:ja" \
    LC_ALL="ja_JP.UTF-8" \
    TZ="Asia/Tokyo"

EXPOSE 161/udp 24005/udp

WORKDIR /opt/hinemos_agent
COPY ./run.sh .

ENTRYPOINT ["/opt/hinemos_agent/run.sh"]

FROM oraclelinux:9

ENV HINEMOS_MAJOR 7.1
ENV HINEMOS_MINOR 0

RUN yum -y update \
 && yum -y install java-1.8.0-openjdk hostname net-snmp vim-common unzip net-snmp-utils sysstat tcpdump lsof wsmancli glibc-langpack-ja \
 && yum -y install https://github.com/hinemos/hinemos/releases/download/v${HINEMOS_MAJOR}.${HINEMOS_MINOR}/hinemos-${HINEMOS_MAJOR}-manager-${HINEMOS_MAJOR}.${HINEMOS_MINOR}-1.el9.x86_64.rpm \
 && yum -y install https://github.com/hinemos/hinemos/releases/download/v${HINEMOS_MAJOR}.${HINEMOS_MINOR}/hinemos-${HINEMOS_MAJOR}-web-${HINEMOS_MAJOR}.${HINEMOS_MINOR}-1.el9.x86_64.rpm \
 && yum clean all \
 && rm -rf /var/cache/yum

ENV LANG="ja_JP.UTF-8" \
    LANGUAGE="ja_JP:ja" \
    LC_ALL="ja_JP.UTF-8" \
    TZ="Asia/Tokyo"

EXPOSE 80 8080 8081 8082 8083 514 514/udp 162/udp

WORKDIR /opt/hinemos
COPY ./run.sh .

ENTRYPOINT ["/opt/hinemos/run.sh"]

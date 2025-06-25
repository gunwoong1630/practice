FROM ubuntu:24.04

# COPY[host_dir | file] [container_dir | file]
COPY container_script.sh /script.sh

RUN chmod +x /script.sh

CMD [ "/script.sh" ]
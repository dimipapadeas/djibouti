# MQTT integration examples

## 1) Run MQTT Mosquitto broker on a docker

To load MQTT Mosquitto docker image just execute:

`docker run -it -p 1883:1883 -p 9001:9001 -v /mosquitto/conf/mosquitto.conf -v /mosquitto/conf/data -v /mosquitto/conf/log eclipse-mosquitto:1.4.12`

![](/img/mosquitto.png)

## 2) MQTT Mosquitto java sample
**mqtt-mosquitto** is a plain standalone example of executing an MQTT Mosquitto pub-sub.


In `mqtt-mosquitto` folder:

build as
`mvn clean install`

After successful build to run Consumer (from the target folder):
`owt-mqtt subscriber`

> Press Ctrl + c to close

To run publisher (from the target folder):
`owt-mqtt publisher "<THE MESSAGE YOU WANT TO PUBLISH>"`

>Note: The publisher sends one message per execution

Consumer:
![](/img/subscriberMQito.png)


Publisher:
![](/img/publisherMQito.png)


## 3) MQTT Mosquitto with Camel sample

**mqttCamelPoc** is a plain standalone example of executing an MQTT Mosquitto pub-sub with [Apache Camel](camel.apache.org/).

In `mqttCamelPoc` folder:

build as
`mvn clean install`

After successful build to run Consumer (from the target folder):
`owt-mqttCamel subscriber`
> Press Ctrl + c to close

To run publisher (from the target folder):
`owt-mqttCamel publisher "<THE MESSAGE YOU WANT TO PUBLISH>"`

>Note: The publisher sends one message per execution.
> Press Ctrl + c to close

Consumer:
![](/img/subscriberCamel.png)



Publisher:
![](/img/publisherCamel.png)



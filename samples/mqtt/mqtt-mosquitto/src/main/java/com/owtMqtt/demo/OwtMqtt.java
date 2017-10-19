package com.owtMqtt.demo;

import org.eclipse.paho.client.mqttv3.MqttException;
import com.owtMqtt.demo.pub.Publisher;
import com.owtMqtt.demo.sub.Subscriber;

public class OwtMqtt {

  public static void main(String[] args) throws MqttException {

    if (args.length < 1) {
      throw new IllegalArgumentException("Must have either 'publisher' or 'subscriber' as argument");
    }
    switch (args[0]) {
      case "publisher":
        Publisher.main(args);
        break;
      case "subscriber":
        Subscriber.main(args);
        break;
      default:
        throw new IllegalArgumentException("Unknown command: " + args[0]);
    }
  }
}
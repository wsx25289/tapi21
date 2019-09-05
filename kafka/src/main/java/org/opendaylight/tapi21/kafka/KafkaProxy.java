/*
 * Copyright © 2017 ZTE, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.tapi21.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaProxy {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaProxy.class);


    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public KafkaProxy() {

    }


    public void init() {
        LOG.info("KafkaProxy init start");
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "10.112.16.145:9092");
        properties.put("acks", "all");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(properties);
        producer.send(new ProducerRecord<>("test", Integer.toString(1)));

        producer.close();
    }

    public void close() {

    }


}

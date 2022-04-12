package com.handson.tinyurl.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration
{

    @Override
    protected String getDatabaseName() {
        return "tinydb";
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }


    @Value("${spring.data.mongodb.uri}")
    public String mongoUri;

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        // customization hook
        builder.applyConnectionString(new ConnectionString(mongoUri));
    }

}

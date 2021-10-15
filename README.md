# Pricefx Example Configuration
This repository is an example of a Pricefx configuration project that provides a showcase of the most significant features. The project is heavily used in the technical documentation on the [Pricefx Developer Portal](https://pricefx.vercel.app/docs).

This project contains
* samples of various configurations for a Pricefx partition.
* sample demo data
* maven goals, to deploy the configuration and data to a sandbox partition

The samples are not meant to be a full project implementation, but rather demonstrations of various concepts, and which api calls to use to achieve them.

Folder _pricefxSrc_ is a configuration package, i.e. configuration of the Pricefx partition in the format understood by Pricefx Studio and Pricefx Packaging Tool.

## How to use this project
You can either only review the configuration files in the repository, or you can also deploy them to the partition and try them in action.

**WARNING**: If you want to deploy it to the partition, then do it on an empty partition, otherwise you will destroy your current setup and data.

# Pricefx Starter

This is a very basic Pricefx configuration project that will help you to get started with development for the Pricefx Platform. Use it to initialize a new Pricefx project!

## Pricefx Stream Maven Plugin

The Pricefx Stream plugin allows you to fetch/deploy/delete data from/to/on your Pricefx partition.

**NOTE**: Do _not_ use the Pricefx Stream Plugin in your CI/CD pipelines on your QA or production environments. Instead, use the pricefx packaging tool. The Pricefx Stream Maven Plugin allows you to fetch/deploy/delete some data that you otherwise cannot do with the Pricefx Packaging Tool (or Pricefx Studio).

### Maven Plugin Setup

The Pricefx Stream Maven Plugin requires four properties to identify and connect to a partition. These properties should not be hard-coded into the `pom.xml` file, but added with a maven profile. You'll find your maven profile under `~/.m2/settings.xml`. If the file does not yet exist, create it and use the following content (but provide your own values for the properties):

````xml
<settings
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd"
        xmlns="http://maven.apache.org/SETTINGS/1.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>
    <profiles>
        <profile>
            <id>pricefx-starter</id>
            <activation>
                <activeByDefault>false</activeByDefault>
            </activation>
            <properties>
                <pricefx-stream.url></pricefx-stream.url>
                <pricefx-stream.partition></pricefx-stream.partition>
                <pricefx-stream.username></pricefx-stream.username>
                <pricefx-stream.password></pricefx-stream.password>
            </properties>
        </profile>
    </profiles>
</settings>
````

### Deploy the Configuration

#### In IntelliJ Idea
* Add support for Maven
* In the Maven tool
  * in _Profiles_ - select the proper Profile (in which you have the properties) 
  * in _pricefxSrc/Plugins/pricefx-stream_, run maven build _pricefx-stream:pricefx-deploy-all_ 

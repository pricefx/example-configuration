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


## How to deploy using Maven

### Configuration
Before you can use the Maven goals, you need to set up 4 properties to your Maven settings file.

In the file ~/.m2/settings.xml, add the properties into your Maven profile (or make a new one, if you do not have any)

```xml
<settings>
    <profiles>
        <profile>
            <id>the profile you use for Maven</id>
            <properties>
                <pricefx-stream.url>https://server.pricefx.eu</pricefx-stream.url>
                <pricefx-stream.partition>pricefx_partition_name</pricefx-stream.partition>
                <pricefx-stream.username>admin_user_name</pricefx-stream.username>
                <pricefx-stream.password>user_password</pricefx-stream.password>
            </properties>
        </profile>
    </profiles>
</settings>
```

### Deploy of configuration and data to the partition

#### In IntelliJ Idea
* Add support for Maven
* In the Maven tool
  * in _Profiles_ - select the proper Profile (in which you have the properties) 
  * in _pricefxSrc/Plugins/pricefx-stream_, run maven build _pricefx-stream:pricefx-deploy-all_ 

<div align="center">
    <div align="center">
        <img src="https://pricefx.vercel.app/pricefx-logo.svg" height="64"/>
    </div>
    <h1>Pricefx Example Configuration</h1>
</div>

<div align="center">

[![https://pricefx.vercel.app](https://pricefx.vercel.app/badges/developer-portal.svg)]()
[![https://pricefx.atlassian.net/wiki/spaces/KB/overview](https://pricefx.vercel.app/badges/documentation.svg)]()
[![issues - example-configuration](https://img.shields.io/github/issues/pricefx/example-configuration)](https://github.com/pricefx/example-configuration/issues)

</div>

This repository is an example of a Pricefx configuration project that provides a showcase of the most significant features.
The project is heavily used in the technical documentation on the [Pricefx Developer Portal](https://pricefx.atlassian.net/wiki/spaces/KB).

This project contains
* samples of various configurations for a Pricefx partition.
* sample demo data
* Maven goals, to deploy the configuration and data to a sandbox partition

The samples are not meant to be a full project implementation, but rather demonstrations of various concepts, and which api calls to use to achieve them.

Folder _pricefxSrc_ is a configuration package, i.e. configuration of the Pricefx partition in the format understood by Pricefx Studio and Pricefx Packaging Tool.
Plus it also contains sample demo data in CSV files. Most of the CSV files are uploaded only by Pricefx Stream Maven plugin, and not by Studio or Packaging tool.

## How to use this project
You can either only review the configuration files in the repository, or you can also deploy them to the partition and try them in action.

**WARNING**: If you want to deploy it to the partition, then do it on an empty partition, otherwise you will destroy your current setup and data.

### Deploy the Configuration

#### In IntelliJ Idea
* Clone this repository as a new Project
* Set up Stream Maven plugin configuration (see below)
* Add support for Maven (or reload the Maven configuration)
* In the Maven tool
  * in _Profiles_ - select the proper Profile (in which you have the properties)
  * in _pricefxSrc/Plugins/pricefx-stream_, run maven build _pricefx-stream:pricefx-deploy-all_


## Pricefx Stream Maven Plugin

The Pricefx Stream plugin allows you to fetch/deploy/delete data from/to/on your Pricefx partition.

**WARNING**: Do _not_ use the Pricefx Stream Plugin in your CI/CD pipelines on your QA or production environments.
Instead, use the pricefx packaging tool.
The Pricefx Stream Maven Plugin allows you to fetch/deploy/delete some data that you otherwise cannot handle with the Pricefx Packaging Tool (or Pricefx Studio).

### Maven Plugin Setup

The Pricefx Stream Maven Plugin requires four properties to identify and connect to a partition.
These properties should not be hard-coded into the `pom.xml` file, but added with a maven profile.
You'll find your maven profile under `~/.m2/settings.xml`.
If the file does not yet exist, create it and use the following content (but provide your own values for the properties):

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

# PSL-Automation-Interview
This is the repository where I upload my test automation interview practice exercise

# How to run the project

exectute the following maven command:

**mvn clean verify**

with the last command the project will execute in firefox using marrionete driver, if you want to run the project in other browser use the following command:

**mvn clean verify -Ddriver={browserName}**

the supported browsers are chrome, firefox and edge.

If you want to generate the reports in a custom directory use the following command:

**mvn clean verify -Ddriver={browserName}  -Dserenity.outputDirectory={path}**

as an example to run the project in chrome use 
**mvn clean verify -Ddriver=chrome  -Dserenity.outputDirectory=target/site/serenity/ReporteChrome**

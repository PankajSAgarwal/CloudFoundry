## Simple data centric apusing springboot,my-sql and cloudfoundry

##Cloudfoundry commands

cf login
cf apps
cf marketplace
cf create-service cleardb spark my-mysql
cf push -p cf-data-demo-0.0.1-SNAPSHOT.jar cf-cats-demo --no-start

cf bind-service cf-cats-demo my-mysql

cf restage cf-cats-demo
cf restart cf-cats-demo

http://cf-cats-demo.cfapps.io/cats

http://cf-cats-demo.cfapps.io/env

cf scale -i 2 cats-demo-app

cf services
cf apps

cf logs --recent cf-cats-demo
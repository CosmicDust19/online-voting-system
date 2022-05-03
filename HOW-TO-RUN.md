## HOW TO RUN

- Make sure that MySQL is running in the background while following these steps
- Copy sql codes in
  [***this***](https://github.com/CosmicDust19/online-voting-system/blob/master/ovs-database/addition/separately/schema.sql)
  file, and paste into phpMyAdmin SQL tab (or execute the codes on MySQL somehow)
- Open project file with IntelliJ IDEA
- IntelliJ IDEA will ask to install dependencies, choose ***Run 'npm install'***. (It can take a while)
- You can use run configurations now.
    - use ***OvsServerApplication*** configuration to run ovs-server (spring)
    - use ***start*** (npm) configuration to run ovs-client (react)
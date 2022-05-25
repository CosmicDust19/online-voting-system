## HOW TO RUN

- Mysql home path will be determined automatically after first run, but it requires to mysql running at first running.
- Open project file with IntelliJ IDEA
- IntelliJ IDEA will ask to install dependencies, choose ***Run 'npm install'*** (If you want to see the UI).
- You can use run configurations now.
    - Use ***OvsServerApplication*** configuration to run ovs-server.
      - It will create the ovs database and its tables if not exist.
      - Default database username is "root" and password is empty. Change if your username and pw are different (from ovs-server/src/main/resources/application.properties).
    - Use ***start*** (npm) configuration to run ovs-client (UI)
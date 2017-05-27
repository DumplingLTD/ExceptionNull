## Setup, Deployment, etc

### IntelliJ Setup
+ Enable `make project automatically`  
  This cuts down the hassle of having to hit "build->make" every time
  you want to test.
  1. Open settings: `[ctrl]` + `[alt]` + `s`
  2. Expand "Build, Execution, Deployment"
  3. Click "Compiler" (don't expand)
  4. Check `make project automatically`
+ Enable automake even when app is running  
  This allows the above to run even if the app is already running. In
  conjunction with the "springloaded" spring plugin, this enables hot
  development.
  1. Open "Find Action": `[ctrl]` + `[shift]` + `a`
  2. Type "registry" and select `registry...`
  3. Find and check option `compiler.automake.allow.when.app.running`
+ Set up SCSS File Watcher  
  The SCSS File Watcher will automatically transpile SCSS (read "sass"
  files) into css format and place the generated css into the resources
  folder.
  1. Open settings: `[ctrl]` + `[alt]` + `s`
  2. Expand "tools"
  3. Click "File watchers"
  4. Click "+" (on the right hand side) and select "SCSS"
  5. In the New File Watcher window, change the followings settings:
     + Show console: `never`
     + Immediate file synchronization: `[unchecked]`
     + Scope: `Project Files`
     + Arguments: `--no-cache --update $FileName$:$ProjectFileDir$/src/main/resources/static/css/$FileNameWithoutExtension$.css`
     + Working directory: `$FileDir$`
     + Output paths to refresh: `$ProjectFileDir$/src/main/resources/static/css/$FileNameWithoutExtension$.css:$ProjectFileDir$/src/main/resources/static/css/$FileNameWithoutExtension$.css.map`
  6. Click "ok" 
+ Verify all maven dependencies are synced between the project `pom.xml`
  and IntelliJ's `<project-name>.iml` file.
+ Set up a run configuration
  This will be the main run for development, allowing debug through the
  IntelliJ console.
  1. Open the run configurations panel: `Run` > `Edit Configurations`
  2. Add a new `Spring Boot` run configuration by clicking the "+" and
     changing the following settings:
     + Main class: `com.jonathanpli.ExceptionNullApplication`
     + Program arguments: `-debug`
     + Use classpath of module: `<project name>`
     + Before launch: Add "make"
  3. Ok!

### How to product a self-packaged, runnable .jar
This is used for deployment or deployment package testing.
1. Verify you version the package properly within `pom.xml`. The setting
   is found within the `<version>...</version>` tags. Follow this
   convention: `[major].[minor].[build]-[SNAPSHOT|RELEASE]`.
   + `[major]` - Era, focus, or engine changes.
   + `[minor]` - Feature releases.
   + `[build]` - Incremented every server push.
   + `[SNAPSHOT|RELEASE]` - `SNAPSHOT` represents a WIP package.
    `RELEASE` represents a shippable package.
2. Run the `package` maven command.  
   This will run all tests and only successfully compile a .jar file if
   the tests pass.
   + Unix: `./mvnw package`
   + Windows: `mvnw.cmd package`
3. Find the output in the root of the `target` folder

### Running in Offline Mode
1. Create or download a server with version >= 0.0.9-SNAPSHOT
2. Download and unzip the offline static content [here](https://s3-us-west-2.amazonaws.com/jpli-capstone/offline-enull.zip)
3. Run the jar using the following command: `java -jar <server jar location> -offline -offlinePath <path>`
   + Replace `<server jar location>` with the location of the server jar file
   + Replace `<path>` with the location of the unzipped static content folder. Include a trailing
     slash. If there are spaces in the path, be sure to quote or escape them. This should also
     accept a relative path (but hasn't been tested).
   + An example: `java -jar enull-0.0.9-SNAPSHOT.jar -offline -offlinePath offline-content/`

###### Advanced
Settings for the build can be changed within the `pom.xml` file under
the `<build>...</build>` tag.

### Server Start
1. Check to see if a shared screen session is already running on the server. `screen -ls`
   + If one isn't, start one with `screen -d -m -S shared` (runs screen detached, as a new 
   session, with the name 'shared')
   + If one is, go to step 2.
2. Attach to the screen. Usually `screen -x <username>/shared`, but the `screen -ls` will tell 
   you what it's called.
   + If the screen had to be started in step 1, do the following:
     + `[ctrl]` + `a`, then type `:multiuser on` and enter.
     + `[ctrl]` + `a`, then type `:acladd <user>`, replacing `<user>` with (`jonathan` or 
       `kodlee`) to add the other user to the allowed access control list.
3. Run the server package. `java -jar <jar name>`.
4. Detach from the screen session. `[ctrl]` + `a` THEN `d`.

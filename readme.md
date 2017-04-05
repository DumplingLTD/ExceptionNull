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
     + Main class: `com.jonthanpli.ExceptionNullApplication`
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

###### Advanced
Settings for the build can be changed within the `pom.xml` file under
the `<build>...</build>` tag.

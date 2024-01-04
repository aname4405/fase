**&larr; [Back to Program README](../README.md)**
# Project 2 CI/CD Design

- [Project 2 CI/CD Design](#project-2-cicd-design)
  - [Introduction](#introduction)
  - [Reference Solution](#reference-solution)
---
## Introduction

Project 2 serves as a foundational step towards creating an automated workflow that subsequent projects can leverage.  Normally, the CI/CD pipeline is created at the beginning of a development project, but this is pushed back to after WEB development modules to allow learners to have a better understanding what they are automating.

The diagram below shows the required pipeline.  At this stage only the React Application will exist so the pipeline will only build the WEB Frontend.  Project 3 will include the build task for Java.



![](./docs/images/pipeline.png)
<figcaption><b>Fig.1 - CI/CD</b></figcaption>

## Reference Solution
```javascript   
pipeline {
    agent any
    stages {
        stage ('Build React') {
            steps {
                git url: 'https://github.com/agray998/simple-node-js-react-npm-app'
                
                bat "npm install"
                bat "npm test"
                bat "npm package"
            }
        }
        stage ('Build Maven') {
            steps {

                git url: 'https://github.com/agray998/SpringBoot-Jenkins',
                    branch: 'main'

                withMaven {

                // Run the maven build
                bat "mvn clean package" // deploy also runs all phases prior to deploy

                } // Maven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs & SpotBugs reports...
            }
        }
    }
    post {
        always {
            mail to: you@example.com,
                 subject: "Jenkins build ${env.BUILD_NUMBER}",
                 body: "Build no. ${env.BUILD_NUMBER} finished with status: ${currentBuild.currentResult}."
        }
    }
}
```

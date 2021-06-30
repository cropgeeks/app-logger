FROM gradle:6-jdk11-openj9 AS builder

LABEL maintainer="sebastian.raubach@hutton.ac.uk"

ARG BRANCH=main

# Force docker to not cache the next line
ADD https://api.github.com/repos/cropgeeks/app-logger/git/refs/heads/master version.json
# Clone the repository
RUN echo "Pulling GitHub branch: $BRANCH"
RUN apk add --no-cache git && \
    git clone -b "$BRANCH" --single-branch --depth 1 https://github.com/cropgeeks/app-logger.git /opt/app-logger

# Download Gradle and build the project
RUN echo "data.directory.external=/data/app-logger" > /opt/app-logger/config.properties && \
    echo "project.name=app-logger" >> /opt/app-logger/gradle.properties && \
    gradle -p /opt/app-logger war

# Now build the final image
FROM tomcat:8-jdk11

LABEL maintainer="sebastian.raubach@hutton.ac.uk"

# Remove all existing apps
RUN mkdir -p /usr/local/tomcat/webapps && \
    rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the war from the previous build into the webapps directory as the ROOT app
COPY --from=builder /opt/app-logger/build/libs/app-logger-*.war /usr/local/tomcat/webapps/ROOT.war

WORKDIR /usr/local/tomcat/

To support `org.owasp:dependency-check-maven`

configure the NVD API key in your Maven `settings.xml` file and the plugin in your `pom.xml`.

request [NVD_API_KEY](https://nvd.nist.gov/developers/request-an-api-key)

`settings.xml`
```xml
<settings>
    <servers>
        <server>
            <id>nvd-api</id>
            <username></username> <!-- not used by NVD; can be left blank -->
            <password>{NVD_API_KEY}</password>
        </server>
    </servers>
</settings>
```

`pom.xml`
```xml
<plugin>
    <groupId>org.owasp</groupId>
    <artifactId>dependency-check-maven</artifactId>
    <version>12.1.1</version>
    <configuration>
        <nvdApiServerId>nvd-api</nvdApiServerId>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

run mvn command to scan check
```bash
mvn org.owasp:dependency-check-maven:check
```

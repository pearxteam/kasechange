import com.github.breadmoirai.githubreleaseplugin.GithubReleaseExtension
import net.pearx.multigradle.util.MultiGradleExtension

val projectChangelog: String by project
val projectDescription: String by project

val sonatypeOssUsername: String? by project
val sonatypeOssPassword: String? by project
val githubAccessToken: String? by project
val devBuildNumber: String? by project


description = projectDescription


plugins {
    id("net.pearx.multigradle.simple.project")
    id("org.jetbrains.kotlin.multiplatform") apply (false)
    id("com.github.breadmoirai.github-release")
    `maven-publish`
    signing
}

configure<MultiGradleExtension> {
    if (devBuildNumber != null) {
        projectVersion = "$projectVersion-dev-$devBuildNumber"
    }
}

configure<PublishingExtension> {
    publications.withType<MavenPublication> {
        pom {
            name.set(artifactId)
            description.set(projectDescription)
            url.set("https://github.com/pearxteam/kasechange")
            licenses {
                license {
                    name.set("Mozilla Public License, Version 2.0")
                    url.set("https://mozilla.org/MPL/2.0/")
                    distribution.set("repo")
                }
            }
            organization {
                name.set("PearX Team")
                url.set("https://pearx.net/")
            }
            developers {
                developer {
                    id.set("mrAppleXZ")
                    name.set("mrAppleXZ")
                    email.set("me@pearx.net")
                    url.set("https://pearx.net/members/mrapplexz")
                    organization.set("PearX Team")
                    organizationUrl.set("https://pearx.net/")
                    roles.set(listOf("developer"))
                    timezone.set("Asia/Yekaterinburg")
                }
            }
            scm {
                url.set("https://github.com/pearxteam/kasechange")
                connection.set("scm:git:git://github.com/pearxteam/kasechange")
                developerConnection.set("scm:git:git://github.com/pearxteam/kasechange")
            }
            issueManagement {
                system.set("GitHub")
                url.set("https://github.com/pearxteam/kasechange/issues")
            }
        }
    }
    repositories {
        maven {
            credentials {
                username = "pearxteam"
                password = githubAccessToken
            }
            name = "github-all"
            url = uri("https://maven.pkg.github.com/pearxteam/kasechange")
        }
        maven {
            credentials {
                username = sonatypeOssUsername
                password = sonatypeOssPassword
            }
            name = "sonatype-oss-release"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }
}

tasks {
    val publishDevelop by registering {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository.name.endsWith("-develop") or it.repository.name.endsWith("-all") })
    }
    val publishRelease by registering {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository.name.endsWith("-release") or it.repository.name.endsWith("-all") })
    }
    val release by registering {
        group = "publishing"
        dependsOn(publishRelease)
        dependsOn(named("githubRelease"))
    }
}

configure<SigningExtension> {
    sign(publishing.publications)
}

configure<GithubReleaseExtension> {
    setToken(githubAccessToken)
    setOwner("pearxteam")
    setRepo("kasechange")
    setTargetCommitish("master")
    setBody(projectChangelog)
    //setReleaseAssets((publishing.publications["maven"] as MavenPublication).artifacts.map { it.file })
}
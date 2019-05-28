import com.github.breadmoirai.githubreleaseplugin.GithubReleaseExtension
import net.pearx.multigradle.util.MultiGradleExtension

val projectChangelog: String by project
val projectDescription: String by project

val pearxRepoUsername: String? by project
val pearxRepoPassword: String? by project
val githubAccessToken: String? by project
val devBuildNumber: String? by project

plugins {
    id("net.pearx.multigradle.simple.project")
    id("kotlin-gradle-plugin") apply (false)
    id("com.github.breadmoirai.github-release")
    `maven-publish`
    signing
}

group = "net.pearx.kasechange"
description = projectDescription

configure<MultiGradleExtension> {
    if (devBuildNumber != null) {
        projectVersion = "$projectVersion-dev-$devBuildNumber"
    }
}

configure<PublishingExtension> {
    publications.withType<MavenPublication> {
        pom {
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
                connection.set("scm:git:git://github.com/pearxteam/kasechange")
                developerConnection.set("scm:git:git://github.com/pearxteam/kasechange")
            }
            issueManagement {
                system.set("GitHub")
                url.set("https://github.com/pearxteam/kasechange/issues")
            }
            ciManagement {
                system.set("Jenkins")
                url.set("https://ci.pearx.net/job/pearxteam/job/kasechange")
            }
        }
    }
    repositories {
        fun AuthenticationSupported.pearxCredentials() {
            credentials {
                username = pearxRepoUsername
                password = pearxRepoPassword
            }
        }
        maven {
            pearxCredentials()
            name = "develop"
            url = uri("https://repo.pearx.net/maven2/develop/")
        }
        maven {
            pearxCredentials()
            name = "release"
            url = uri("https://repo.pearx.net/maven2/release/")
        }
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

tasks {
    register("publishDevelop") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository == project.the<PublishingExtension>().repositories["develop"] })
    }
    register("publishRelease") {
        group = "publishing"
        dependsOn(withType<PublishToMavenRepository>().matching { it.repository == project.the<PublishingExtension>().repositories["release"] })
        dependsOn(named("githubRelease"))
    }
}
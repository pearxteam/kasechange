import com.github.breadmoirai.githubreleaseplugin.GithubReleaseExtension
import net.pearx.multigradle.util.MultiGradleExtension

val projectChangelog: String by project

val pearxRepoUsername: String? by project
val pearxRepoPassword: String? by project
val githubAccessToken: String? by project
val devBuildNumber: String? by project

plugins {
    id("net.pearx.multigradle.simple.project")
    id("kotlin-gradle-plugin") apply (false)
    id("com.github.breadmoirai.github-release")
    `maven-publish`
}

group = "net.pearx"

configure<MultiGradleExtension> {
    if(devBuildNumber != null) {
        projectVersion = "$projectVersion-dev-$devBuildNumber"
    }
}

configure<PublishingExtension> {
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
package com.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.language.postfixOps

class UserSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("https://reqres.in") // Here is the root for all relative URLs

  val scn = scenario("user test")
    .exec(http("get first user")
      .get("/api/users/1"))
    .pause(1)

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}

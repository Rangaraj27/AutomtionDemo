$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Regressiontestcase.feature");
formatter.feature({
  "line": 1,
  "name": "Regression Test",
  "description": "",
  "id": "regression-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 13644692701,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login user",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "user enters \u003cusername\u003e and \u003cpassword\u003e",
  "rows": [
    {
      "cells": [
        "admin@yourstore.com",
        "admin"
      ],
      "line": 6
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "AdminTest.user_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 9672168700,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Login Test Scenario",
  "description": "",
  "id": "regression-test;login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 22,
      "value": "#  Given user enters \u003cusername\u003e and \u003cpassword\u003e"
    },
    {
      "line": 23,
      "value": "#   | admin@yourstore.com | admin |"
    }
  ],
  "line": 24,
  "name": "verify the  user is on home page",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminTest.verify_the_user_is_on_home_page()"
});
formatter.result({
  "duration": 758903300,
  "status": "passed"
});
formatter.after({
  "duration": 1285517499,
  "status": "passed"
});
formatter.uri("Regressiontestcase2.feature");
formatter.feature({
  "line": 1,
  "name": "Regression Test1",
  "description": "",
  "id": "regression-test1",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11262934500,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Search Product",
  "description": "",
  "id": "regression-test1;search-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@RegressionTest1"
    }
  ]
});
formatter.step({
  "comments": [
    {
      "line": 6,
      "value": "#Given user enters \u003cusername\u003e and \u003cpassword\u003e"
    },
    {
      "line": 7,
      "value": "# | admin@yourstore.com | admin |"
    }
  ],
  "line": 8,
  "name": "verify the  user is on home page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "search the Dashboard\u003cdashboard\u003e with product \u003cproduct\u003e and \u003cvalue\u003e",
  "rows": [
    {
      "cells": [
        "Catalog",
        "Products",
        "$100 Physical Gift Card"
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "veriy product is dispalyed",
  "rows": [
    {
      "cells": [
        "$100 Physical Gift Card"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "AdminTest.verify_the_user_is_on_home_page()"
});
formatter.result({
  "duration": 60043108000,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.fail(Assert.java:96)\r\n\tat stepdefinitions.AdminTest.verify_the_user_is_on_home_page(AdminTest.java:69)\r\n\tat ✽.And verify the  user is on home page(Regressiontestcase2.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminTest.search_the_product_product(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminTest.veriy_product_is_dispalyed(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 573637600,
  "status": "passed"
});
});
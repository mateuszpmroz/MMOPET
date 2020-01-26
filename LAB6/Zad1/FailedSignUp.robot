*** Settings ***
Library  SeleniumLibrary

*** Variables ***
${BROWSER}   chrome
${SELSPEED}  0.0s

*** Test Cases ***
Failed SignUp
    [Setup]  Run Keywords  Open Browser  http://automationpractice.com/index.php  ${BROWSER}
    ...              AND   Set Selenium Speed  ${SELSPEED}
    # open    http://automationpractice.com/index.php
    click    link=Sign in
    Wait Until Element Is Visible  email_create
    click    id=email_create
    type    id=email_create    jdjydc3no@tlen.pl
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]
    Wait Until Element Is Visible  id_gender2
    click    id=id_gender2
    click    id=customer_firstname
    type    id=customer_firstname    656
    click    id=customer_lastname
    type    id=customer_lastname    5655665
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='*'])[4]/following::span[1]
    click    id=passwd
    click    id=passwd
    doubleClick    id=passwd
    type    id=passwd    444
    Wait Until Element Is Visible  xpath=(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::div[1]
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::div[1]
    select    id=days    3
    click    id=days
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::div[1]
    select    id=months    2
    click    id=months
    click    id=years
    select    id=years    2016
    click    id=years
    click    id=address1
    type    id=address1    h
    click    id=city
    type    id=city    bbb
    click    id=id_state
    select    id=id_state    3
    click    id=id_state
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Receive special offers from our partners!'])[1]/following::div[1]
    click    id=postcode
    type    id=postcode    89-99
    click    id=phone_mobile
    type    id=phone_mobile    76657
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='lastname'])[1]/following::li[1]
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Create an account'])[1]/following::div[1]
    [Teardown]  Close Browser

*** Keywords ***
open
    [Arguments]    ${element}
    Go To          ${element}

clickAndWait
    [Arguments]    ${element}
    Click Element  ${element}

click
    [Arguments]    ${element}
    Click Element  ${element}

sendKeys
    [Arguments]    ${element}    ${value}
    Press Keys     ${element}    ${value}

submit
    [Arguments]    ${element}
    Submit Form    ${element}

type
    [Arguments]    ${element}    ${value}
    Input Text     ${element}    ${value}

selectAndWait
    [Arguments]        ${element}  ${value}
    Select From List   ${element}  ${value}

select
    [Arguments]        ${element}  ${value}
    Select From List by Value   ${element}  ${value}

verifyValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

verifyTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertConfirmation
    [Arguments]                  ${value}
    Alert Should Be Present      ${value}

assertText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

assertTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

waitForTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

doubleClick
    [Arguments]           ${element}
    Double Click Element  ${element}

doubleClickAndWait
    [Arguments]           ${element}
    Double Click Element  ${element}

goBack
    Go Back

goBackAndWait
    Go Back

runScript
    [Arguments]         ${code}
    Execute Javascript  ${code}

runScriptAndWait
    [Arguments]         ${code}
    Execute Javascript  ${code}

setSpeed
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

setSpeedAndWait
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

verifyAlert
    [Arguments]              ${value}
    Alert Should Be Present  ${value}

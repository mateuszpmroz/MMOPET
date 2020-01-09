*** Settings ***
Library  program.py

** Variables ***

** Test Cases ***
Square Recognize
  Check Figure  Square  2  2  2  2

Rectangle Recognize
  Check Figure  Rectangle  2  3  2  3

Rectangle Recognize
  Check Figure  Quadrangle  2  3  4  5

*** Keywords ***
Check Figure
  [Arguments]  ${word}  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  ${results} =  recognize figure  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  Should Be Equal  ${results}  ${word} 



*** Settings ***
Library  program.py

** Variables ***

** Test Cases ***
Square Recognize
  Check Figure  Square  2  2  2  2

Rectangle Recognize
  Check Figure  Rectangle  2  3  2  3

Quadrangle Recognize
  Check Figure  Quadrangle  2  3  4  5

Unrecognized Quadrangle
  Check Figure  Unrecognized  2  3  3  12

Equilateral Triangle Recognize
  Check Figure  Equilateral Triangle  4  4  4  0

Isosceles Triangle Recognize
  Check Figure  Isosceles Triangle  3  3  4  0

Triangle Recognize
  Check Figure  Triangle  4  5  6  0

Unrecognized Triangle
  Check Figure  Unrecognized  3  7  61  0

Wrong Sides Length
  Check Figure  Wrong Sides Length  3  -1  5  0


*** Keywords ***
Check Figure
  [Arguments]  ${word}  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  ${results} =  recognize figure  ${sideA}  ${sideB}  ${sideC}  ${sideD}
  Should Be Equal  ${results}  ${word} 



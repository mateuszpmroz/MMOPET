#!/bin/sh
#-*- coding: utf-8 -*-

def recognize_figure(sideA, sideB, sideC, sideD): 
  sideA = int(sideA)
  sideB = int(sideB)
  sideC = int(sideC)
  sideD = int(sideD)

  if  sideA <= 0 or sideB <= 0 or sideC <= 0 or (sideD and sideD <= 0):
    return "Wrong Sides Length"

  maxOfSides = max(sideA, sideB, sideC, sideD)
  sumOfSides = sideA + sideB + sideC + sideD

  # Quadrangle
  if (sideD):
    if sideA == sideB and sideB == sideC and sideC == sideD:
      return "Square"
    
    if sideA == sideC and sideB == sideD:
      return "Rectangle"

    if maxOfSides < (sumOfSides - maxOfSides):
      return "Quadrangle"

    return "Unrecognized"

  # Trojkąt
  if sideA == sideB == sideC:
    return "Equilateral Triangle"

  if sideA == sideB:
    return "Isosceles Triangle"

  if sideA + sideB > sideC and sideB + sideC > sideA and sideA + sideC > sideB:
    return "Triangle"

  return "Unrecognized"
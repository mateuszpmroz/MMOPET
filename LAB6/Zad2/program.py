#!/bin/sh
#-*- coding: utf-8 -*-

def recognize_figure(sideA, sideB, sideC, sideD): 
  sideA = int(sideA)
  sideB = int(sideB)
  sideC = int(sideC)
  sideD = int(sideD)

  if  sideA <= 0 or sideB <= 0 or sideC <= 0 or (sideD and sideD <= 0):
    return "Bok nie może wynosić 0 lub mniej."

  maxOfSides = max(sideA, sideB, sideC, sideD)
  sumOfSides = sideA + sideB + sideC + sideD

  #Czworobok
  if (sideD):
    if sideA == sideB and sideB == sideC and sideC == sideD:
      return "Kwadrat"
    
    if sideA == sideC and sideB == sideD:
      return "Prostokąt"

    if maxOfSides < (sumOfSides - maxOfSides):
      return "Czworobok"

    return "Nierozpoznano"

  # Trojkąt
  if sideA == sideB == sideC:
    return "Trojkąt równoboczny"

  if sideA == sideB:
    return "Trojkąt równoramienny"

  if sideA + sideB > sideC and sideB + sideC > sideA and sideA + sideC > sideB:
    return "Trójkąt różnoramienny"

  return "Nierozpoznano"
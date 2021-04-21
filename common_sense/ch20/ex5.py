import decimal
from decimal import Decimal
from typing import List

MIN_DEGREE = Decimal(97.0)
MAX_DEGREE = Decimal(99.0)
STEP = Decimal(0.1)
decimal.getcontext().prec = 3


def sort_readings(readings: List[float]) -> List[float]:
    counters = {}
    for reading in readings:
        if reading in counters:
            counters[reading] = counters[reading] + 1
        else:
            counters[reading] = 1
    result = []
    degree = MIN_DEGREE
    while degree <= MAX_DEGREE:
        reading = float (degree)
        if reading in counters:
            for i in range(0, counters[reading]):
                result.append(reading)
        degree += STEP
    return result


print(sort_readings([98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1]))

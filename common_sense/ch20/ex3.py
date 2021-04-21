from typing import List


def max_one_sale_profit(prices: List[int]) -> int:
    min_price = prices[0]
    max_profit = 0
    for price in prices:
        profit = price - min_price
        if price < min_price:
            min_price = price
        elif profit > max_profit:
            max_profit = profit
    return max_profit


prices = [10, 7, 5, 8, 11, 2, 6]
print(max_one_sale_profit(prices))

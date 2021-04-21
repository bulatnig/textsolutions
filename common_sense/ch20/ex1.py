from typing import List, Dict


def find_versatile_players(sport1_players: List[Dict], sport2_players: List[Dict]) -> List[str]:
    names1 = set([build_full_name(player) for player in sport1_players])
    result = []
    for player in sport2_players:
        full_name = build_full_name(player)
        if full_name in names1:
            result.append(full_name)
    return result


def build_full_name(player: Dict[str, str]) -> str:
    return player["first_name"] + " " + player["last_name"]


basketball_players = [
{"first_name": "Jill", "last_name": "Huang", "team": "Gators"},
{"first_name": "Janko", "last_name": "Barton", "team": "Sharks"},
{"first_name": "Wanda", "last_name": "Vakulskas", "team": "Sharks"},
{"first_name": "Jill", "last_name": "Moloney", "team": "Gators"},
{"first_name": "Luuk", "last_name": "Watkins", "team": "Gators"}
]
football_players = [
{"first_name": "Hanzla", "last_name": "Radosti", "team": "32ers"},
{"first_name": "Tina", "last_name": "Watkins", "team": "Barleycorns"},
{"first_name": "Alex", "last_name": "Patel", "team": "32ers"},
{"first_name": "Jill", "last_name": "Huang", "team": "Barleycorns"},
{"first_name": "Wanda", "last_name": "Vakulskas", "team": "Barleycorns"}
]

print(find_versatile_players(basketball_players, football_players))


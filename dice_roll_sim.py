import random
import time

def get_user_input(prompt, valid_responses):
    while True:
        user_input = input(prompt)
        if user_input.upper() in valid_responses:
            return user_input.upper()
        else:
            print("Please answer correctly.")

def numOfDice():
    while True:
        user_input = input("How many dice do you want to roll? ")
        if user_input.isdigit() and int(user_input) > 0:
            return int(user_input)
        else:
            print("Again, please answer correctly with a number.")

def dice_gen(numberOfDice):
    return [random.randint(1, 6) for _ in range(numberOfDice)]

def statistics(numberOfDice, dice_rolls):

    accumulation = 0
    average = 0
    deviation = 0
    diceAmount = [0, 0, 0, 0, 0, 0]
    portion = [0, 0, 0, 0, 0, 0]
    for dice in dice_rolls:
        accumulation += dice
        diceAmount[dice + 1] += 1
    
    average = accumulation / numberOfDice
    deviation = abs(3.5 - average)

    return [numberOfDice, diceAmount, portion, average, deviation]


def printer(stats):
    print(f"\b\nJust as a reminder, you rolled {numberOfDice} dice.")
    index = 1
    while index < 7:
        portion = diceAmount[index] / numberOfDice
        print(f"This is how often you rolled a '{index}': {diceAmount[index]}. That equals {portion * 100} %.")
        index += 1
    print(f"And to remind you of another fact, 1/6 equals 16.66 %.")
    print(f"Your last dice roll average equaled to: {average}")
    print(f"The deviation of the theoretical average point of 3.5 equals to: {deviation}")
    print(f"The deviation times one hundred equals to: {deviation * 100}")
    print(f"So anyway, ...")

def main():
    running = get_user_input("Do you want to roll some dice? (y/n): ", ['Y', 'N'])
    numberOfDice = 0

    while running == 'Y' or running == 'R':
        if not running == 'R':
            numberOfDice = numOfDice()
        dice_rolls = dice_gen(numberOfDice)
        print("Here are your dice rolls:")
        for roll in dice_rolls[:-1]:
            print(f"{roll}, ", end='')
            time.sleep(0.001)
        print(dice_rolls[-1])
        stats = statistics(numberOfDice, dice_rolls)
        printer(stats)
        running = get_user_input("Do you want to roll the dice once again or repeat? (y/n/r): ", ['Y', 'N', 'R'])
    print("You exited.")
    time.sleep(1)

if __name__ == "__main__":
    main()

import random
import time

def get_user_input(prompt, valid_responses):
    while True:
        user_input = input(prompt)
        if user_input.upper() in valid_responses:
            return user_input.upper()
        else:
            print("Please answer correctly.")

def get_number_of_dice():
    while True:
        user_input = input("How many dice do you want to roll? ")
        if user_input.isdigit() and int(user_input) > 0:
            return int(user_input)
        else:
            print("Again, please answer correctly with a number.")

def dice_gen(number_of_dice):
    dice_rolls = []
    for _ in range(1, number_of_dice + 1):
        roll = random.randint(1, 6)
        dice_rolls.append(roll)
        print(roll, end='', flush=True)
        if _ != number_of_dice:
            print(", ", end='')
    return dice_rolls

def statistics(number_of_dice, dice_rolls):
    dice_amount = [0] * 6
    portion = [0] * 6
    average = sum(dice_rolls) / number_of_dice
    deviation = abs(3.5 - average)
    for dice in dice_rolls:
        dice_amount[dice - 1] += 1
    for i in range(6):
        portion[i] = dice_amount[i] / number_of_dice
    return [number_of_dice, dice_amount, portion, average, deviation]

def printer(stats):
    print(f"\b\nJust as a reminder, you rolled {stats[0]} dice.")
    for index in range(6):
        print(f"This is how often you rolled a '{index + 1}': {stats[1][index]}. "
              f"That equals {stats[2][index] * 100} %.")
    print(f"And to remind you of another fact, 1/6 equals 16.66 %.")
    print(f"Your last dice roll average equaled to: {stats[3]}")
    print(f"The deviation of the theoretical average point of 3.5 equals to: {stats[4]}")
    print(f"The deviation times one hundred equals to: {stats[4] * 100}")
    print(f"So anyway, ...")

def main():
    running = get_user_input("Do you want to roll some dice? (y/n): ", ['Y', 'N'])
    number_of_dice = 0
    while running == 'Y' or running == 'R':
        if running != 'R':
            number_of_dice = get_number_of_dice()
        print("Here are your dice rolls:")
        dice_rolls = dice_gen(number_of_dice)
        stats = statistics(number_of_dice, dice_rolls)
        printer(stats)
        running = get_user_input("Do you want to roll the dice once again or repeat? (y/n/r): ", ['Y', 'N', 'R'])
    print("You exited.")
    time.sleep(1)

if __name__ == "__main__":
    main()

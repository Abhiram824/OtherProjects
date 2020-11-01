import random

def getCardValue(cardFace):
    cardNum = 0
    if cardFace[0:1] == "A":
        cardNum = 1
    elif cardFace[0:1] == "1" or cardFace[0:1] == "J" or cardFace[0:1] == "Q" or cardFace[0:1] == "K":
        cardNum = 0
    else:
        cardNum = int(cardName)
    return cardNum

def giveScore(card1, card2):
    realScore = 0
    if (card1 + card2 < 10):
        realScore = card2 + card1
    else:
        realScore = (card2 + card1)%10
    return realScore
        
def aWinner (aScore, bScore):
    winner = False
    if aScore > bScore:
        winner = True
    return winner

def bWinner (aScore, bScore):
    winner = False
    if bScore > aScore:
        winner = True
    return winner
def tie (aScore, bScore):
    tie = False
    if bScore == aScore:
        tie = True
    return tie
def makeDeck():
    deckSuites = []
    deckNames = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
    i = 0
    while (i < 13):
        deckSuites.append(deckNames[i] + " Spades" )
        deckSuites.append(deckNames[i] + " Clubs")
        deckSuites.append(deckNames[i] + " Diamonds" )
        deckSuites.append(deckNames[i] + " Hearts" )
        i+=1
    card = random.randint(0,len(deckSuites) - 2)
    deckSuites.pop(card)
    return deckSuites[card]

money = 100
RealAScore = 0
RealBScore = 0
while (money > 0):
    choice = str (input ("Choose either Player A or Player B to win: "))
    makeDeck()
    a1 = makeDeck()
    a2 = makeDeck()
    b1 = makeDeck()
    b2 = makeDeck()
    playerAScore = getCardValue(a1) + getCardValue(a2)
    playerBScore = getCardValue(b1) + getCardValue(b2)
    
    print("Player A cards [ " + a1 + " , " + a2 + " ]" )
    if playerAScore == 8 or playerAScore == 9:
        RealAScore = playerAScore 
        print("initial hand value = " +  str(RealAScore) + "\nPlayer A is done" + "\n")
    elif playerAScore > 9:
        print ("initial hand value = " + str((playerAScore)%10))
        extraCardA = makeDeck()
        print ("Player A draws: " + extraCardA)
        RealAScore = giveScore(playerAScore, getCardValue(extraCardA))
        print ("Player A final total is: " + str(RealAScore) + "\n")
    else:
        print("initial hand value = " + str(playerAScore))
        extraCardA = makeDeck()
        print ("Player A draws: " + extraCardA)
        RealAScore = giveScore(playerAScore, getCardValue(extraCardA))
        print ("Player A final total is: " + str(RealAScore) + "\n")
               
    print("Player B cards [" + b1 + " , " + b2 + "]" )
    if playerBScore == 8 or playerBScore == 9:
        RealBScore = playerBScore
        print("initial hand value = " +  str(RealBScore) + "\nPlayer B is done" + "\n")
    elif playerBScore > 9:
        print ("initial hand value = " + str((playerBScore)%10))
        extraCardB = makeDeck()
        print ("Player B draws: " + extraCardB)
        RealBScore = giveScore(playerBScore, getCardValue(extraCardB))
        print ("Player B final total is: " + str(RealBScore) + "\n")
    else:
        print("initial hand value = " + str(playerBScore))
        extraCardB = makeDeck()
        print ("Player B draws: " + extraCardB)
        RealBScore = giveScore(playerBScore, getCardValue(extraCardB))
        print ("Player B final total is: " + str(RealBScore) + "\n")
               
    if choice == "B":
        if bWinner(RealAScore, RealBScore):
            money += 10
            print ("B wins\nYou Won\nMoney is: " + str (money) + "\n")
        elif tie(RealAScore, RealBScore):
            money -=10
            print("It's a tie\nNobody Wins\nMoney is: " + str(money) + "\n")
        else:
            money -= 10
            print("A wins\nYou Lost\nMoney is: " + str (money) + "\n")
    else:
         if aWinner(RealAScore, RealBScore):
            money += 10
            print ("A wins\nYou Won\nMoney is: " + str (money) + "\n")
         elif tie(RealAScore, RealBScore):
            money -=10
            print("It's a tie\nNobody Wins\nMoney is: " + str(money) + "\n")
         else:
            money -= 10
            print("B wins\nYou Lost\nMoney is: " + str (money) + "\n")

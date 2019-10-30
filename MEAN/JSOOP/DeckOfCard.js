class Card{
    constructor(suit, number){
        this.suit = suit;
        this.number = number;

        //take care of Ace, J, Q, and K
        if(number == 1){
            this.display = "A";
        }
        else if (number == 11){
            this.display = "J";
        }
        else if (number == 12){
            this.display = "Q";
        }
        else if (number == 13){
            this.display = "K";
        }
        else{
            this.display = String(number);
        }
    }
}

class Deck{
    constructor(){
        this.reset();
        this.shuffle();
    }
    reset(){
        this.deck=[]
        for(var i =0; i<52; i++){
            var suit;
            if(i<13){
                suit="Hearts";
            }
            else if(i<26){
                suit = "Diamonds";
            }
            else if (i<39){
                suit = "Clubs";
            }
            else{
                suit = "Spades"
            }
            var number = (i%13)+1;
            this.deck.push(new Card(suit, number));
        }
        return this;
    }


    display(){
        for(var i=0; i<this.deck.length;i++){
            console.log(this.deck[i].display, 'of', this.deck[i].suit);
        }
    }
    shuffle(){
        for(var i= this.deck.length-1; i>0;i--){
            var j =Math.floor(Math.random()*(i+1));
            [this.deck[i], this.deck[j]] = [this.deck[j], this.deck[i]]
        }
    }

    drawFrom(){
        // console.log(this.deck.pop());
        return this.deck.pop();
    }
}


class Player{
    constructor(name,deck){
        this.name = name;
        this.deck = deck;
        this.hand = [];
        this.discard = [];
    }
    draw(num){
        for(var i=0; i<num;i++){
            if(this.deck.deck.length>0){
                this.hand.push(this.deck.drawFrom());
                // for(var i=0;i<this.hand.length;i++){
                //     console.log(this.hand[i]);
                // }
            }else{
                console.log("The deck is empty!");
                break;
            }
        }
        return this;
    }

    displayDraw(){
        console.log(`${this.name}'s hand: `);
        
        for(var i=0;i<this.hand.length;i++){
            console.log(`${this.hand[i].display} of  ${this.hand[i].suit}`)
        }
        return this;
    }
    discardCard(card){
        if(card < this.hand.length){
            var thisCard = this.hand[card];
            console.log(`Discarding ${this.hand[card].display} of ${this.hand[card].suit}`);
            this.discard.push(thisCard);
            this.hand.slice(card,1);
        }else{
            console.log('Invalid, cannot discard this card!');
        }
        return this;
    }
    discardHand(){
        while(this.hand[0]){
            this.discard.push(this.hand.pop());
        }
        console.log('Card Discard');
        return this;
    }

}

// var card1 = new Card("Hearts", "Seven", 7)
// card1.show();

// var deck1 = new Deck()
// deck1.display()
// deck1.drawFrom()
// deck1.display()
// deck1.reset()
// deck1.display()
// deck1.shuffle()
// deck1.drawFrom()
// // deck1.shuffle()
// var deck1 = new Deck();
// // deck1.drawFrom()
// // deck1.display()
// var play2 = new Player("Tom",deck1);
// play2.draw(1).displayDraw();

var deck2 = new Deck();
var play3 = new Player("Alex", deck2);
play3.draw(2)
play3.discardCard(1);
play3.discardHand();
// play2.displayDraw();
// console.log(play2.name)
// // play2.hand()
// // console.log(play2.name)
// for(var i=0;i<play2.hand;i++){
//     console.log(play2.hand[i])
// }

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
                suit="Diamonds";
            }
            else if(i<26){
                suit = "Spades";
            }
            else if (i<39){
                suit = "Clubs";
            }
            else{
                suit = "Hearts"
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



}


var card1 = new Card("Hearts", "Seven", 7)
card1.show();
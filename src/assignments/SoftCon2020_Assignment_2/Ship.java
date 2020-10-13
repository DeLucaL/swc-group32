package assignments.SoftCon2020_Assignment_2;

interface Ship {

}

class Carrier implements Ship {
    int size = 6;
}

class Battleship implements Ship {
    int size = 4;
}

class Submarine implements Ship {
    int size = 3;
}

class PatrolBoat implements Ship {
    int size = 2;
}

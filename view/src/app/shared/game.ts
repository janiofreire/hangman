import { Dificulte } from "./dificulte";
import { Hint } from "./hint";
import { HintResult } from "./hint-result";
import { Result } from "./result";
import { Word } from "./word";

export class Game {
    id:number;
	word:Word;
	hints:Hint[];
	maxGuesses:number;
	dificulte:Dificulte;
	result:Result;
}


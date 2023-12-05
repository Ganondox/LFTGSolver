import java.util.List;

public abstract class InformationState {

    GameHead gameHead;
    List<Integer> observation;

    @Override
    public boolean equals(Object obj) {

        InformationState other = (InformationState) obj;

        if(!gameHead.equals(other.gameHead)) return false;

        if(observation.size() != other.observation.size()) return false;

        for(int i = 0; i < observation.size(); i++){
            if(observation.get(i) != other.observation.get(i)) return  false;
        }

        return true;
    }
}

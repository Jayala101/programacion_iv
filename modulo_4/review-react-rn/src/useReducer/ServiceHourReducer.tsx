import { useReducer } from "react";
import { View, Text, Button } from "react-native";

type State = {
    hours: number;
};

type Action = 
    | { type: 'ADD_HOUR' }
    | { type: 'REMOVE_HOUR' }
    | { type: 'RESET' };

const initialState: State = {
    hours: 0
};

function serviceHourReducer(state: State, action: Action): State {
    switch (action.type) {
        case 'ADD_HOUR':
            return { hours: state.hours + 1 };
        case 'REMOVE_HOUR':
            return { hours: Math.max(0, state.hours - 1) };
        case 'RESET':
            return initialState;
        default:
            return state;
    }
}

export default function ServiceHourReducer() {
    const [state, dispatch] = useReducer(serviceHourReducer, initialState);

    return (
        <View style={{padding: 16, borderWidth: 1, borderRadius: 8, marginBottom: 14, borderColor: '#ddd'}}>
            <Text style={{fontSize: 18, fontWeight: 'bold', marginBottom: 16, textAlign: 'center'}}>
                Gestión de Horas de Servicio
            </Text>
            
            <Text style={{fontSize: 16, marginBottom: 20, textAlign: 'center'}}>
                Horas Acumuladas: <Text style={{fontWeight: '700', fontSize: 24, color: '#007bff'}}>{state.hours}</Text>
            </Text>

            <View style={{gap: 10, marginBottom: 16}}>
                <View style={{marginVertical: 5}}>
                    <Button 
                        title="Agregar Hora" 
                        onPress={() => dispatch({ type: 'ADD_HOUR' })}
                    />
                </View>
                <View style={{marginVertical: 5}}>
                    <Button 
                        title="Remover Hora" 
                        onPress={() => dispatch({ type: 'REMOVE_HOUR' })}
                        disabled={state.hours === 0}
                    />
                </View>
                <View style={{marginVertical: 5}}>
                    <Button 
                        title="Reiniciar" 
                        onPress={() => dispatch({ type: 'RESET' })}
                        color="#dc3545"
                    />
                </View>
            </View>

            <Text style={{fontSize: 14, textAlign: 'center', color: '#666', marginTop: 10}}>
                Total Facturable: ${(state.hours * 50).toFixed(2)}
            </Text>
        </View>
    );
}
import { useState, useMemo } from "react";
import { View, Text, TextInput } from "react-native";


export default function TestPreassureCheck() {

    const [currentPsi, setCurrentPsi] = useState(0);
    const [tire, setTire] = useState('delantera');
    const IDEAL_PSI = 32;

    const needPsi = useMemo(() => {
        const idealPsi = tire.toLowerCase() === 'trasera' ? IDEAL_PSI - 2 : IDEAL_PSI;
        return Math.max(0, idealPsi - currentPsi);
    }, [currentPsi, tire]);

    return (
        <View style={{padding:16, borderWidth:1, borderRadius:8, marginBottom:14}}>
            <Text style={{fontSize:18, fontWeight:"bold", marginBottom:10}}>
              Verificación de Presión de Neumático
            </Text>
            <TextInput
                keyboardType="numeric"
                placeholder="PSI Actual"
                onChangeText={(v) => setCurrentPsi(Number(v) || 0)}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <TextInput
                placeholder="Tipo de Neumático (delantera/trasera)"
                onChangeText={setTire}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <Text style={{marginTop:10}}>
                PSI Necesario: <Text style={{fontWeight:"700"}}>{needPsi.toFixed(1)} PSI</Text>
            </Text>
        </View>
    )
}
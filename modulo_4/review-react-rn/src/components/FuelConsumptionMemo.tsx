import { useState, useMemo } from "react";
import { View, Text, TextInput } from "react-native";

export default function FuelConsumptionMemo() {

    const [distance, setDistance] = useState(0);
    const [efficiency, setEfficiency] = useState(0);
    const [load, setLoad] = useState('no');
    
    const total = useMemo(() => {
        if (efficiency <= 0 || distance <= 0) return 0;
        const base = (distance / 100) * efficiency;
        return load.toLowerCase() === "si" ? base * 1.1 : base;
    }, [distance, efficiency, load]);

    return (
        <View style={{padding:16, borderWidth:1, borderRadius:8, marginBottom:14}}>
            <Text style={{fontSize:18, fontWeight:"bold", marginBottom:10}}>
              Consumo de Combustible
            </Text>
            <TextInput
                keyboardType="numeric"
                placeholder="Distancia (km)"
                onChangeText={(v) => setDistance(Number(v) || 0)}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <TextInput
                keyboardType="numeric"
                placeholder="Eficiencia (L/100km)"
                onChangeText={(v) => setEfficiency(Number(v) || 0)}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <TextInput
                placeholder="Carga adicional (si/no)"
                onChangeText={setLoad}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <Text style={{marginTop:10}}>
                Total: <Text style={{fontWeight:"700"}}>{total.toFixed(2)} L</Text>
            </Text>
        </View>
    )
}
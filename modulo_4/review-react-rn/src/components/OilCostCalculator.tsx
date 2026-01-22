import { useState } from "react";
import { View, Text, TextInput } from "react-native";

export default function OilCostCalculator() {

    const [liters, setLiters] = useState(0);
    const [price, setPrice] = useState(0);
    const total = price * liters;

    return (
        <View style={{padding:16, borderWidth:1, borderRadius:8, marginBottom:14}}>
            <Text style={{fontSize:18, fontWeight:"bold", marginBottom:10}}>
              Calculadora de Costo de Aceite
            </Text>
            <TextInput
                keyboardType="numeric"
                placeholder="Litros"
                onChangeText={(v)=>setLiters(Number(v)||0)}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <TextInput
                keyboardType="numeric"
                placeholder="Precio por Litro"
                onChangeText={(v)=>setPrice(Number(v)||0)}
                style={{
                    borderWidth:1,
                    padding:10,
                    marginTop:10,
                }}
            />
            <Text style={{marginTop:10}}>
                Total: <Text style={{fontWeight:"700"}}>${total.toFixed(2)}</Text>
            </Text>
        </View>
    )
}
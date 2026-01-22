// src/types/index.ts

// INTERFACE para DTOs (extensible con 'extends')
export interface UserDTO {
  id: string;
  email: string;
  fullName: string;
  createdAt?: Date; // Propiedad opcional
}

// TYPE para uniones discriminadas
export type ApiState<T> =
  | { status: "IDLE"; data: null; error: null }
  | { status: "LOADING"; data: null; error: null }
  | { status: "SUCCESS"; data: T; error: null }
  | { status: "ERROR"; data: null; error: string };

// TYPE para composición
export type Product = {
  id: string;
  name: string;
  price: number;
  inStock: boolean;
};

// INTERFACE que extiende otra
export interface AdminUser extends UserDTO {
  role: "admin" | "superadmin";
  permissions: string[];
}

// Ejemplo de uso en componente
export const exampleState: ApiState<UserDTO> = {
  status: "SUCCESS",
  data: {
    id: "user-123",
    email: "ejemplo@mail.com",
    fullName: "Juan Pérez"
  },
  error: null
};

// Union type para estados de carga (mejor práctica con discriminated unions)
export type LoadState<T> =
  | { type: "idle" }
  | { type: "loading" }
  | { type: "success"; data: T }
  | { type: "error"; message: string; code?: string };

// DTO para productos
export interface ProductDTO {
  id: string;
  name: string;
  price: number;
  inStock?: boolean;
}

// Estado de éxito de ejemplo
export const successState: LoadState<ProductDTO[]> = {
  type: "success",
  data: [
    { id: "1", name: "Laptop", price: 999.99, inStock: true },
    { id: "2", name: "Mouse", price: 29.99, inStock: true },
    { id: "3", name: "Teclado", price: 79.99, inStock: false }
  ]
};


export type RootStackParamList = {
  Home: undefined;
  Products: undefined;
  Details: { id: string; title: string };
  Profile: { userId: string; name: string; lastname: string };
  Settings: undefined;
  LoginForm: undefined;
  Raiz: undefined;
};
export interface Product {
    id: string;
    name: string;
    description: string;
    price: number;
    skuCode?: string;
}

export interface UpdateProductRequest {
    name?: string;
    description?: string;
    price?: number;
}

export interface CreateProductRequest {
    name: string;
    description: string;
    price: number;
}
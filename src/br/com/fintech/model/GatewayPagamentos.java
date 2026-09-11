package br.com.fintech.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GatewayPagamentos {
    private Map<String, CarteiraDigital> carteiras = new Map<String, CarteiraDigital>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public CarteiraDigital get(Object key) {
            return null;
        }

        @Override
        public CarteiraDigital put(String key, CarteiraDigital value) {
            return null;
        }

        @Override
        public CarteiraDigital remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends CarteiraDigital> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return Set.of();
        }

        @Override
        public Collection<CarteiraDigital> values() {
            return List.of();
        }

        @Override
        public Set<Entry<String, CarteiraDigital>> entrySet() {
            return Set.of();
        }
    }
}

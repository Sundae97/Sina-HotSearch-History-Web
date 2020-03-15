<template>
    <v-card
            max-width="310px"
            min-width="200px"
            class="mx-auto"
            light
            elevation="12"
    >
        <v-list-item>
            <v-list-item-avatar color="grey"></v-list-item-avatar>
            <v-list-item-content>
                <v-list-item-title>Our Changing Planet</v-list-item-title>
                <v-list-item-subtitle>by Kurt Wagner</v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

        <v-img  height="200"
                src="https://cdn.vuetifyjs.com/images/cards/mountain.jpg"
        />

        <v-card-text>
            Visit ten places on our planet that are undergoing the biggest changes today.
        </v-card-text>

        <v-card-actions>
            <v-icon class="margin-n" size="18">mdi-share-circle</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">88.6k</span>
            <v-divider
                    class="mx-4"
                    inset
                    vertical
            ></v-divider>
            <v-icon class="margin-n" size="18">mdi-message</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">8.6k</span>
            <v-divider
                    class="mx-4"
                    inset
                    vertical
            ></v-divider>
            <v-icon class="margin-n" size="18">mdi-thumb-up</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">120</span>
            <v-spacer></v-spacer>
            <v-btn icon>
                <v-icon>mdi-send</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "BlogCard",
        prop:{
            value:null
        }
    }
</script>

<style scoped>
    .margin-n{
        margin: 10px 2px;
    }
</style>

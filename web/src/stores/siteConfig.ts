import { defineStore } from 'pinia'
import { SiteConfig } from '@/stores/interface'

export const useSiteConfig = defineStore('siteConfig', {
    state: (): SiteConfig => {
        return {
            siteName: '',
            recordNumber: '',
            version: '',
            cdnUrl: '',
            apiUrl: '',
            upload: {
                mode: 'local',
                maxSize: 0,
                mimeType: '',
                saveName: '',
            },
        }
    },
    actions: {
        dataFill(state: SiteConfig) {
            this.$state = state
        },
    },
})
